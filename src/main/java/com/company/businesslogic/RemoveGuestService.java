package com.company.businesslogic;

import com.company.businesslogic.api.RemoveGuestRequest;
import com.company.businesslogic.api.RemoveGuestResponse;

public interface RemoveGuestService {

    RemoveGuestResponse removeByName(RemoveGuestRequest request);

}
