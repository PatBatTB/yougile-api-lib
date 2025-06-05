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

    PagingContainer<User> handleUserList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.asString());
        JsonNode pagingNode = rootNode.get("paging");
        int count = pagingNode.get("count").asInt();
        int limit = pagingNode.get("limit").asInt();
        int offset = pagingNode.get("offset").asInt();
        boolean next = pagingNode.get("next").asBoolean();
        List<User> userList = new ArrayList<>();
        ArrayNode arrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode node: arrayNode) {
            userList.add(mapper.readValue(node.toString(), User.class));
        }
        return new PagingContainer<>(count, limit, offset, next, userList);
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

    PagingContainer<AuthCompany> handleAuthCompanyList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        List<AuthCompany> authCompanyList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(content.asString());
        JsonNode pagingNode = rootNode.get("paging");
        int count = pagingNode.get("count").asInt();
        int limit = pagingNode.get("limit").asInt();
        int offset = pagingNode.get("offset").asInt();
        boolean next = pagingNode.get("next").asBoolean();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            authCompanyList.add(mapper.readValue(contentNode.toString(), AuthCompany.class));
        }
        return new PagingContainer<>(count, limit, offset, next, authCompanyList);
    }

    public static PagingContainer<Project> handleProjectList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.asString());
        JsonNode pagingNode = rootNode.get("paging");
        int count = pagingNode.get("count").asInt();
        int limit = pagingNode.get("limit").asInt();
        int offset = pagingNode.get("offset").asInt();
        boolean next = pagingNode.get("next").asBoolean();
        List<Project> projectList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            projectList.add(mapper.readValue(contentNode.toString(), Project.class));
        }
        return new PagingContainer<>(count, limit, offset, next, projectList);
    }

    public static Project handleProject(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Project.class);
    }

    public static PagingContainer<ProjectRole> handleProjectRoleList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        JsonNode pagingNode = rootNode.get("paging");
        int count = pagingNode.get("count").asInt();
        int limit = pagingNode.get("limit").asInt();
        int offset = pagingNode.get("offset").asInt();
        boolean next = pagingNode.get("next").asBoolean();
        List<ProjectRole> roleList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            roleList.add(mapper.readValue(contentNode.toString(), ProjectRole.class));
        }
        return new PagingContainer<>(count, limit, offset, next, roleList);
    }

    public static ProjectRole handleProjectRole(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), ProjectRole.class);
    }

    public static PagingContainer<Department> handleDepartmentList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<Department> departmentList =  new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            departmentList.add(mapper.readValue(contentNode.toString(), Department.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), departmentList);
    }

    public static Department handleDepartment(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Department.class);
    }
}
