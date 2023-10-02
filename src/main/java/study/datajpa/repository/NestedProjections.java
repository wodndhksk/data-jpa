package study.datajpa.repository;

public interface NestedProjections {

    String getUsername();
    TeamInfo getTeam();
    interface TeamInfo{
        String getName();
    }
}
