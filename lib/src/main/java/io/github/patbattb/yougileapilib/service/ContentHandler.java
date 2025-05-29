package io.github.patbattb.yougileapilib.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.patbattb.yougileapilib.domain.*;
import lombok.experimental.UtilityClass;
import org.apache.http.client.fluent.Content;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
class ContentHandler {

    Id handleId(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Id.class);
    }

    User handleUser(Content content) throws JsonProcessingException {
        //TODO need to checkout
        return new JsonMapper().readValue(content.toString(), User.class);
    }

    List<User> handleUserList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        List<User> userList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(content.asString());
        ArrayNode arrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode node: arrayNode) {
            userList.add(mapper.readValue(node.toString(), User.class));
        }
        return userList;
    }

    Company handleCompany(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Company.class);
    }

    boolean handleResult(Content content) throws JsonProcessingException {
        String validString = "ok";
        JsonMapper mapper = new JsonMapper();
        JsonNode node = mapper.readTree(content.toString());
        return node.get("result").asText().equals(validString);
    }

    AuthKey handleAuthKey(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), AuthKey.class);
    }

    List<AuthKeyDetails> handleAuthKeyList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        ArrayNode arrayNode = (ArrayNode) mapper.readTree(content.toString());
        List<AuthKeyDetails> authKeyDetailsList = new ArrayList<>();
        for (JsonNode node: arrayNode) {
            authKeyDetailsList.add(mapper.readValue(node.toString(), AuthKeyDetails.class));
        }
        return authKeyDetailsList;
    }

    List<AuthCompany> handleAuthCompanyList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        List<AuthCompany> authCompanyList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(content.asString());
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            authCompanyList.add(mapper.readValue(contentNode.toString(), AuthCompany.class));
        }
        return authCompanyList;
    }
}
