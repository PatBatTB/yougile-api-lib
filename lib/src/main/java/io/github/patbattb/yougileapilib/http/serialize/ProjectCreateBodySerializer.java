package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.UserRole;
import io.github.patbattb.yougileapilib.domain.body.ProjectCreateBody;

import java.io.IOException;

public class ProjectCreateBodySerializer extends JsonSerializer<ProjectCreateBody> {
    @Override
    //TODO need to check out
    public void serialize(ProjectCreateBody value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", value.getTitle());
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
