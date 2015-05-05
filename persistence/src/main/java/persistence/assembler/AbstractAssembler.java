package persistence.assembler;

import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public abstract class AbstractAssembler<T, U> implements Assembler<T, U> {

    public abstract U toBusinessObject(T t);

    public abstract T toEntity(U u);

    public Iterable<T> toEntityList(Iterable<U> entityList) {
        List<T> list = null;
        if (!CollectionUtils.isEmpty(Lists.newArrayList(entityList))) {
            list = Lists.transform(Lists.newArrayList(entityList), new Function<U, T>() {
                @Override
                public T apply(U input) {
                    return toEntity(input);
                }
            });
        } else {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }

    public Iterable<U> toBusinessList(Iterable<T> entityList) {
        List<U> list = null;
        if (!CollectionUtils.isEmpty(Lists.newArrayList(entityList))) {
            list = Lists.transform(Lists.newArrayList(entityList), new Function<T, U>() {
                @Override
                public U apply(T input) {
                    return toBusinessObject(input);
                }
            });
        } else {
            list = Collections.EMPTY_LIST;
        }
        return list;
    }
}
