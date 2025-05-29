package io.github.patbattb.yougileapilib.domain.body;

public abstract class BodyBuilder<T extends RequestBody> {

    protected final T body;

    public BodyBuilder(T body) {
        this.body = body;
    }

    public T build() {
        return  body;
    }
}
