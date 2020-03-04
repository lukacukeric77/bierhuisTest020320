package be.vdab.bierhuis.sessions;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
@SessionScope
public class Mandje implements Serializable {
    private static final long serialVersionUID=1L;
    public final Set<Long> ids = new LinkedHashSet<>();

    public void fillIn(long id){
        ids.add(id);
    }

    public boolean hasInside(long id){
        return ids.contains(id);
    }

    public boolean isFilled(){
        return !ids.isEmpty();
    }

}
