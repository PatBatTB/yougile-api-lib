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

    Id handleId(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Id.class);
    }

    User handleUser(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), User.class);
    }

    PagingContainer<User> handleUserList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.asString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<User> userList = new ArrayList<>();
        ArrayNode arrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode node: arrayNode) {
            userList.add(mapper.readValue(node.toString(), User.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), userList);
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

    PagingContainer<AuthCompany> handleAuthCompanyList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        List<AuthCompany> authCompanyList = new ArrayList<>();
        JsonNode rootNode = mapper.readTree(content.asString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            authCompanyList.add(mapper.readValue(contentNode.toString(), AuthCompany.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), authCompanyList);
    }

    PagingContainer<Project> handleProjectList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.asString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<Project> projectList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            projectList.add(mapper.readValue(contentNode.toString(), Project.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), projectList);
    }

    Project handleProject(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Project.class);
    }

    PagingContainer<ProjectRole> handleProjectRoleList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<ProjectRole> roleList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            roleList.add(mapper.readValue(contentNode.toString(), ProjectRole.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), roleList);
    }

    ProjectRole handleProjectRole(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), ProjectRole.class);
    }

    PagingContainer<Department> handleDepartmentList(Content content) throws JsonProcessingException {
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

    Department handleDepartment(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Department.class);
    }

    PagingContainer<Board> handleBoardList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<Board> boardList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            boardList.add(mapper.readValue(contentNode.toString(), Board.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), boardList);
    }

    Board handleBoard(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Board.class);
    }

    PagingContainer<Column> handleColumnList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<Column> columnList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            columnList.add(mapper.readValue(contentNode.toString(), Column.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), columnList);
    }

    Column handleColumn(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Column.class);
    }

    PagingContainer<Task> handleTaskList(Content content) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
        JsonNode rootNode = mapper.readTree(content.toString());
        PagingData paging = mapper.readValue(rootNode.get("paging").toString(), PagingData.class);
        List<Task> taskList = new ArrayList<>();
        ArrayNode contentArrayNode = (ArrayNode) rootNode.get("content");
        for (JsonNode contentNode: contentArrayNode) {
            taskList.add(mapper.readValue(contentNode.toString(), Task.class));
        }
        return new PagingContainer<>(paging.count(), paging.limit(), paging.offset(), paging.next(), taskList);
    }

    Task handleTask(Content content) throws JsonProcessingException {
        return new JsonMapper().readValue(content.toString(), Task.class);
    }
}
