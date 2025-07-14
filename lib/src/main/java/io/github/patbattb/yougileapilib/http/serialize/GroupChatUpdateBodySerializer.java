package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.GroupChatUser;
import io.github.patbattb.yougileapilib.domain.body.GroupChatUpdateBody;

import java.io.IOException;

public class GroupChatUpdateBodySerializer extends JsonSerializer<GroupChatUpdateBody> {
    @Override
    public void serialize(GroupChatUpdateBody value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        if (value.getDeleted() != null) {
            gen.writeBooleanField("deleted", value.getDeleted());
        }
        if (value.getTitle() != null) {
            gen.writeStringField("title", value.getTitle());
        }
        if (value.getUsers() != null) {
            gen.writeFieldName("users");
            gen.writeStartObject();
            for (GroupChatUser user: value.getUsers()) {
                gen.writeFieldName(user.getId());
                gen.writeStartObject();
                gen.writeBooleanField("notified", user.isNotified());
                gen.writeEndObject();
            }
            gen.writeEndObject();
        }
        gen.writeEndObject();
    }
}
