package evedev.csgoadminpart.repository.impl;

import evedev.csgoadminpart.entity.dao.Admin;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.exceptions.UnexpectedSituation;
import evedev.csgoadminpart.repository.dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * DAO MySQL implementation for Admin.
 *
 * @author Alexander Eveler
 */
@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private static final String NAMED_QUERY_GET_ALL_ADMINS = "Admin.getAll";
    private static final String NAMED_QUERY_GET_BY_LOGIN_ADN_PASSWORD = "Admin.getByNameAndPassword";

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Admin> getAll() {
        Query query = entityManager.createNamedQuery(NAMED_QUERY_GET_ALL_ADMINS);
        List<Admin> admins = query.getResultList();
        entityManager.close();

        return admins;
    }

    @Override
    public Admin getById(long id) throws RecordNotFoundException {
        Admin admin = entityManager.find(Admin.class, id);
        entityManager.close();

        if (admin == null) {
            throw new RecordNotFoundException();
        }

        return admin;
    }

    @Override
    public List<Admin> getByLoginAndPassword(String login, String password) throws RecordNotFoundException, UnexpectedSituation {
        Query query = entityManager.createNamedQuery(NAMED_QUERY_GET_BY_LOGIN_ADN_PASSWORD);
        query.setParameter(1, login);
        query.setParameter(2, password);
        List<Admin> admins = query.getResultList();
        entityManager.close();

        if (admins.size() == 0) {
            throw new RecordNotFoundException();
        }

        // TODO: 05.04.2016 need set login UNIQUE into database
        if (admins.size() > 1){
            throw new UnexpectedSituation("Record more than one");
        }

        return admins;
    }

    @Override
    @Transactional
    public Admin update(Admin admin) throws RecordNotFoundException {
        Admin verifiedAdmin = getById(admin.getId());
        Admin updatedAdmin = entityManager.merge(verifiedAdmin);
        entityManager.close();

        return updatedAdmin;
    }

    @Override
    @Transactional
    public Admin add(Admin admin) {
        Admin addedAdmin = entityManager.merge(admin);
        entityManager.close();

        return addedAdmin;
    }

    @Override
    public void remove(Admin admin) throws RecordNotFoundException {
        Admin verifiedAdmin = getById(admin.getId());
        entityManager.remove(verifiedAdmin);
        entityManager.close();
    }
}
