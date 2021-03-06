package de.madcyph3r.materialnavigationdrawer.menu;

import java.util.ArrayList;
import java.util.List;

import de.madcyph3r.materialnavigationdrawer.menu.item.MaterialSection;

public class MaterialMenu {

    public static int SECTION = 0;
    public static int BOTTOM_SECTION = 1;
    public static int DIVISOR = 2;

    private List<Object> sections = new ArrayList<Object>();
    //private Map<Integer, MaterialSection> sections = new HashMap<Integer, MaterialSection>();

    public List<Object> getSections() {
        return sections;
    }

    public void setSections(List<Object> sections) {
        this.sections = sections;
    }

    public void addSection(Object section) {
        getSections().add(section);
    }

    public void addSection(Object section, int position) {
        getSections().add(position, section);
    }

    public void removeItem(Object section) {
        getSections().remove(section);
    }

    public void removeItem(int position) {
        getSections().remove(position);
    }

    public int getItemPosition(Object item) {
        return getSections().indexOf(item);
    }

    public Object getItem(int position) {
        return getSections().get(position);
    }

    // return the real pos int the list, considered devisor and label
    public int getRealSectionPosition(MaterialSection section) {
       // if (section instanceof MaterialSection) {
        return getSections().indexOf(section);
        /*} else {
            throw new RuntimeException("Object is not a MaterialSection");
        }*/
    }

    // return position, does not considered devisor and label
    public int getSectionPosition(MaterialSection section) {
        //if (section instanceof MaterialSection) {
        int pos = 0;
        for (int i = 0; i < getSections().size(); i++) {
            if (getSections().get(i) instanceof MaterialSection) {
                if (getSections().get(i) == section) {
                    return pos;
                }
                pos++;
            }
        }
       /* } else {
            throw new RuntimeException("Object is not a MaterialSection");
        }*/
        return -1;
    }

    public MaterialSection getSection(int position) {
        int pos = 0;
        for (int i = 0; i < getSections().size(); i++) {
            if (getSections().get(i) instanceof MaterialSection) {
                if (pos == position) {
                    return (MaterialSection) getSections().get(i);
                }
                pos++;
            }
        }
        return null;
    }

    public MaterialSection getRealSection(int position) {
        if (getSections().get(position) instanceof MaterialSection) {
            return (MaterialSection) getSections().get(position);
        } else {
            return null;
        }
    }
}
