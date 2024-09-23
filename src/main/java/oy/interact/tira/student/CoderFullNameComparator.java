package oy.interact.tira.student;

import oy.interact.tira.model.Coder;
import java.util.Comparator;

public class CoderFullNameComparator implements Comparator<Coder> {

    @Override
    public int compare(Coder coder1, Coder coder2) {
        int lastNameComparison = coder1.getLastName().compareTo(coder2.getLastName());
        
        if (lastNameComparison == 0) {
            return coder1.getFirstName().compareTo(coder2.getFirstName());
        }
        return lastNameComparison;
    }
}
