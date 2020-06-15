package com.edination.api.preAuthorisation.MasterCode;

import com.edination.api.preAuthorisation.model.Episode;
import com.edination.api.preAuthorisation.model.PreAuthDetail;

import java.util.Comparator;

public class preauthComparator implements Comparator<PreAuthDetail> {
    public int compare(PreAuthDetail a, PreAuthDetail b)
    {
        return -a.getEpisode().getAdmissionDate().compareTo(b.getEpisode().getAdmissionDate());
    }
}
