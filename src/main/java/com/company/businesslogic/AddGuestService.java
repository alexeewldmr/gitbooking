package com.company.businesslogic;

import com.company.businesslogic.api.AddGuestRequest;
import com.company.businesslogic.api.AddGuestResponse;

public interface AddGuestService {

    AddGuestResponse addGuest(AddGuestRequest request);
}
