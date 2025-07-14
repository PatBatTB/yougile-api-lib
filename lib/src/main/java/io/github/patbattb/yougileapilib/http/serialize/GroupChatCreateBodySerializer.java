package io.github.patbattb.yougileapilib.http.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.github.patbattb.yougileapilib.domain.GroupChatUser;
import io.github.patbattb.yougileapilib.domain.body.GroupChatCreateBody;

import java.io.IOException;

public class GroupChatCreateBodySerializer extends JsonSerializer<GroupChatCreateBody> {
    @Override
    public void serialize(GroupChatCreateBody value, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("title", value.getTitle());
        gen.writeFieldName("users");
        gen.writeStartObject();
        for (GroupChatUser user: value.getUsers()) {
            gen.writeFieldName(user.getId());
            gen.writeStartObject();
            gen.writeBooleanField("notified", user.isNotified());
            gen.writeEndObject();
        }
        gen.writeEndObject();
        gen.writeEndObject();
    }
}
