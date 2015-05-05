package service.assembler;

public abstract class AbstractAssembler<T, U> {

    public abstract U toViewObject(T t);

    public abstract T toEntity(U u);
}
