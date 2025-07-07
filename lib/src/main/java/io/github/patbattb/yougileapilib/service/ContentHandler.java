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

    boolean handleResult(Content content) throws JsonProcessingException {
        String validString = "ok";
        JsonMapper mapper = new JsonMapper();
        JsonNode node = mapper.readTree(content.toString());
        return node.get("result").asText().equals(validString);
    }

    List<Id> handleIdList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        List<Id> idList = new ArrayList<>();
        if (rootNode != null && rootNode.isArray()) {
            for (JsonNode node: rootNode) {
                idList.add(new Id(node.asText()));
            }
        }
        return idList;
    }

    <T> PagingContainer<T> handlePagingContent(Content content, Class<T> contentClazz) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<T> taskList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            taskList.add(mapper.readValue(contentNode.toString(), contentClazz));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), taskList);
    }

    Id handleId(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Id.class);
    }

    User handleUser(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), User.class);
    }

    Company handleCompany(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Company.class);
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

    Project handleProject(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Project.class);
    }

    ProjectRole handleProjectRole(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), ProjectRole.class);
    }

    Department handleDepartment(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Department.class);
    }

    Board handleBoard(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Board.class);
    }

    Column handleColumn(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Column.class);
    }

    Task handleTask(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Task.class);
    }
}
