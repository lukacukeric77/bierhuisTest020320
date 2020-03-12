package be.vdab.bierhuis.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.*;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID=1L;
    public final Map<Long, Long> idsEnAantal = new LinkedHashMap<>();

    public void fillIn(long id, long aantal){
        idsEnAantal.put(id, aantal);
    }

    public boolean isFilled(){
        return !idsEnAantal.isEmpty();
    }

    public Long getAantal(long id){
        return idsEnAantal.get(id);
    }

    public Set<Long> getKeys(){
        return idsEnAantal.keySet();
    }



}
