package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.domain.body.DepartmentCreateBody;

import java.io.IOException;


public class DepartmentCreateBodySerializer extends JsonSerializer<DepartmentCreateBody> {
    @Override
    public void serialize(DepartmentCreateBody value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", value.getTitle());
        if (value.getParentId() != null) {
            gen.writeStringField("parentId", value.getParentId());
        }
        if (!value.getUsers().isEmpty()) {
            gen.writeFieldName("users");
            gen.writeStartObject();
            for (UserRole user : value.getUsers()) {
                gen.writeStringField(user.getId(), user.getRoleId());
            }
            gen.writeEndObject();
        }
        gen.writeEndObject();
    }
}
