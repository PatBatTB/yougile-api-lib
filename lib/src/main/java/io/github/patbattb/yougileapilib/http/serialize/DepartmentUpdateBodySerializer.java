package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.domain.body.DepartmentUpdateBody;

import java.io.IOException;

public class DepartmentUpdateBodySerializer extends JsonSerializer<DepartmentUpdateBody> {
    @Override
    public void serialize(DepartmentUpdateBody value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("deleted", value.getDeleted());
        if (value.getTitle() != null) {
            gen.writeStringField("title", value.getTitle());
        }
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
