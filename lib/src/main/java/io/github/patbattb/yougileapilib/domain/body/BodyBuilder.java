package io.github.patbattb.yougileapilib.domain.body;

abstract class BodyBuilder<T extends RequestBody> {

    protected final T body;

    protected BodyBuilder(T body) {
        this.body = body;
    }

    public T build() {
        return  body;
    }
}
