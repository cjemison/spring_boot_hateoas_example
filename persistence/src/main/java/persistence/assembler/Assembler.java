package persistence.assembler;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

public abstract class Assembler<T, U> {

    public abstract U toBusinessObject(T t);

    public abstract T toEntity(U u);

    public Iterable<T> toEntityList(List<U> entityList) {
        List<T> list = null;
        if (!CollectionUtils.isEmpty(entityList)) {
            list = Lists.transform(entityList, new Function<U, T>() {
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

    public Iterable<U> toBusinessList(List<T> entityList) {
        List<U> list = null;
        if (!CollectionUtils.isEmpty(entityList)) {
            list = Lists.transform(entityList, new Function<T, U>() {
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
