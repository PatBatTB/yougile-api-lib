package io.github.patbattb.yougileapilib.domain.body;

/**
 * The class is used to form and further transmit the request body.
 * It can be declared as a nested RequestBody class.
 * Must be parameterized by the type that will be constructed.
 * An instance of the type being constructed takes as a constructor argument and returns it via the {@link BodyBuilder#build()} method.
 * Before calling the {@link BodyBuilder#build()} method, additional methods must be implemented that define fields of the parameterized type, for example:
 * {@code
 * public Builder name(String value) {
 *     body.name = value;
 *     return this;
 * }}
 * @param <T> implementation of the RequestBody
 */
abstract class BodyBuilder<T extends RequestBody> {

    protected final T body;

    protected BodyBuilder(T body) {
        this.body = body;
    }

    /**
     * Must be called after finish constructing.
     * @return built instance of the RequestBody.
     */
    public T build() {
        return  body;
    }
}
