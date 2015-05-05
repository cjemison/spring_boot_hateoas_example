package persistence.assembler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

public abstract class AbstractAssembler<T, U> implements Assembler<T, U> {
    private final static Logger LOGGER = LoggerFactory.getLogger(AbstractAssembler.class);

    public abstract U toBusinessObject(T t);

    public abstract T toEntity(U u);

    public Iterable<T> toEntityList(Iterable<U> entityList) {
        List<T> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(Lists.newArrayList(entityList))) {
            LOGGER.debug("Entity List: {}", entityList);
            for (U u : entityList) {
                list.add(toEntity(u));
            }
        } else {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }

    public Iterable<U> toBusinessList(Iterable<T> entityList) {
        List<U> list = new ArrayList<>();
        if (!CollectionUtils.isEmpty(Lists.newArrayList(entityList))) {
            LOGGER.debug("Entity List: {}", entityList);
            for (T t : entityList) {
                list.add(toBusinessObject(t));
            }
        } else {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }
}
