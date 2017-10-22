package com.company.jdbc;


import com.company.DatabaseUtil;
import com.company.database.GuestDAO;
import com.company.database.jdbc.GuestDAOImpl;
import com.company.domian.Guest;
import org.junit.Before;
import org.junit.Test;


import java.util.List;
import java.util.Optional;

import static com.company.domian.GuestBuilder.createGuest;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GuestDAOImplTest {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private GuestDAO guestDAO = new GuestDAOImpl();

    @Before
    public void init() {
        databaseUtil.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Guest guest = create( "Name AAA", "Description VVV");
        assertThat(guest.getId(), is(notNullValue()));

        Optional<Guest> guestFromDB = guestDAO.getById(guest.getId());

        assertThat(guestFromDB.isPresent(), is(true));
        assertEquals(guest.getId(), guestFromDB.get());
        assertEquals(guest.getName(), guestFromDB.get().getName());
        assertEquals(guest.getDescription(), guestFromDB.get().getDescription());
    }
    @Test
    public void testGetByName() throws Exception {
        Guest guest = create( "Name AAABBB", "Description VVV");
        Optional<Guest> guestFromDB = guestDAO.getByName(guest.getName());

        assertThat(guestFromDB.isPresent(), is(true));
        assertEquals(guest.getId(), guestFromDB.get());
        assertEquals(guest.getName(), guestFromDB.get().getName());
        assertEquals(guest.getDescription(), guestFromDB.get().getDescription());
    }
    @Test
    public void testGetAll() throws Exception {
        Guest guest1 = create( "Name AAABBB 1", "Description VVV");
        Guest guest2 = create( "Name AAABBB 2", "Description VVV");

        List<Guest> guests = guestDAO.getAll();
        assertThat(guests.size(), is(2));
        assertThat(guests.contains(guest1), is(true));
        assertThat(guests.contains(guest2), is(true));
    }
    @Test
    public void testDelete() throws Exception {
        Guest guest = create( "Name AAABBB", "Description VVV");
        List<Guest> guests = guestDAO.getAll();
        assertThat(guests.size(), is(1));

        guestDAO.delete(guest);
        guests = guestDAO.getAll();
        assertThat(guests.size(), is(0));

        Optional<Guest> guestFromDB = guestDAO.getById(guest.getId());
        assertThat(guestFromDB.isPresent(), is(false));
    }

    private Guest create(String name, String description) {
        Guest guest = createGuest()
                .withName(name)
                .withDescription(description).build();
        return guestDAO.save(guest);
    }
}
