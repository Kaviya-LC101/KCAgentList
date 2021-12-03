package org.Housing.KCAgentList.data;

import org.Housing.KCAgentList.models.HouseList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HouseListData {
    private static final Map<Integer, HouseList> houselists =new HashMap<>();

    public static Collection<HouseList>getALL(){
                return houselists.values();
    }

    public static HouseList getById(int id){
        return houselists.get(id);
    }
    public static void add(HouseList houseList){
        houselists.put(houseList.getId(),houseList);
    }

    public static void remove(int id){
        houselists.remove(id);
    }

}
