package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.ProjectUser;
import io.github.patbattb.yougileapilib.domain.body.ProjectUpdateBody;

import java.io.IOException;

public class ProjectUpdateBodySerializer extends JsonSerializer<ProjectUpdateBody> {
    @Override
    public void serialize(ProjectUpdateBody value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeBooleanField("deleted", value.getDeleted());
        if (value.getTitle() != null) {
            gen.writeStringField("title", value.getTitle());
        }
        if (!value.getUsers().isEmpty()) {
            gen.writeFieldName("users");
            gen.writeStartObject();
            for (ProjectUser user : value.getUsers()) {
                gen.writeStringField(user.getUserId(), user.getRoleId());
            }
            gen.writeEndObject();
        }
        gen.writeEndObject();
    }
}
