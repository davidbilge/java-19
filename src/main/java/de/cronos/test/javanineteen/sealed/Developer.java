package de.cronos.test.javanineteen.sealed;

public sealed class Developer implements SystemUser {
    public static final class RegularDeveloper extends Developer {

    }

    public static final class RockstarDeveloper extends Developer {
    }

}
