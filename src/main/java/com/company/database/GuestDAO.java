package com.company.database;

import com.company.domian.Guest;

import java.util.List;
import java.util.Optional;

public interface GuestDAO {
    Guest save(Guest guest);
    Optional<Guest> getById(Long id);
    Optional<Guest> getByName(String name);
    void delete(Guest guest);
    List<Guest> getAll();
}
