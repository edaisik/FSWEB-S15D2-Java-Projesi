package com.workintech.softwareCompany.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTask;
    private Set<Task> bobsTask;
    private Set<Task> carolsTask;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTask, Set<Task> bobsTask, Set<Task> carolsTask, Set<Task> unassignedTasks) {
        this.annsTask = annsTask;
        this.bobsTask = bobsTask;
        this.carolsTask = carolsTask;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTask() {
        return annsTask;
    }

    public Set<Task> getBobsTask() {
        return bobsTask;
    }

    public Set<Task> getCarolsTask() {
        return carolsTask;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.toLowerCase().equals("bob")){
            return bobsTask;
        }

        if(taskOwner.toLowerCase().equals("ann")){
            return annsTask;
        }

        if(taskOwner.toLowerCase().equals("carol")){
            return carolsTask;
        }

        if(taskOwner.toLowerCase().equals("all")){
            return getUnion(bobsTask, annsTask, carolsTask);
        }

        return new HashSet<>();
    }

    //[Set<Task> tasks1, Set<Task> tasks2, Set<Task> tasks3]
//    public Set<Task> getUnion(Set<Task>... tasks){
//
//    }
    public Set<Task> getUnion(Set<Task>... tasks){
        Set<Task> totals = new LinkedHashSet<>();
        for(Set<Task> taskSet: tasks){
            totals.addAll(taskSet);
        }
        return totals;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
       Set<Task> intersections = new HashSet<>(first);
       intersections.retainAll(second);
       return intersections;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }

    public void justData(String data){
        System.out.println("Hello World");
    }
}
