package com.company.businesslogic.api;

public class RemoveGuestResponse {

    private boolean removed;

    public RemoveGuestResponse(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}
