package io.github.patbattb.yougileapilib.http.deserialize;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.BeforeAll;

public abstract class AbstractDeserializerTest {

    protected static JsonMapper mapper;

    @BeforeAll
    static void beforeAll() {
        mapper = new JsonMapper();
    }
}
