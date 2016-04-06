package evedev.csgoadminpart.repository.dao;

import evedev.csgoadminpart.entity.dao.Admin;
import evedev.csgoadminpart.exceptions.RecordNotFoundException;
import evedev.csgoadminpart.exceptions.UnexpectedSituation;

import java.util.List;

/**
 * @author Alexander Eveler
 */
public interface AdminRepository {

    List<Admin> getAll();

    Admin getById(long id) throws RecordNotFoundException;

    List<Admin> getByLoginAndPassword(String login, String password) throws RecordNotFoundException, UnexpectedSituation;

    Admin update(Admin admin) throws RecordNotFoundException;

    Admin add(Admin admin);

    void remove(Admin admin) throws RecordNotFoundException;
}
