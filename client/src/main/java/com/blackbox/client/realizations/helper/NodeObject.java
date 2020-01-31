package com.blackbox.client.realizations.helper;


import entities.Answer;
import entities.NodeMessage;

import java.util.List;

public class NodeObject {

    NodeMessage message;
    List<Answer> answers;

    public NodeObject(NodeMessage message, List<Answer> answers){
        this.message = message;
        this.answers = answers;
    }
}
