package com.company.domian;

public class GuestBuilder {
    private Long id;
    private String name;
    private String description;

    private GuestBuilder() {}

    public static GuestBuilder createGuest() {
        return new GuestBuilder();
    }
    public static Guest createGuest(String name,
                                    String description) {
        return createGuest()
                .withName(name)
                .withDescription(description).build();
    }
    public Guest build() {
        Guest guest = new Guest();
        guest.setId(id);
        guest.setName(name);
        guest.setDescription(description);
        return guest;
    }
    public GuestBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    public GuestBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public GuestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
