package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.domain.body.ProjectEditBody;

import java.io.IOException;

public class ProjectEditBodySerializer extends JsonSerializer<ProjectEditBody> {
    @Override
    public void serialize(ProjectEditBody value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("deleted", value.isDeleted());
        if (value.getTitle() != null) {
            gen.writeStringField("title", value.getTitle());
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
