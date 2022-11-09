package de.cronos.test.javanineteen.sealed;

/**
 * Since Java 17
 * <a href="https://openjdk.org/jeps/409">JEP 409</a>
 */
public sealed interface SystemUser permits Admin, RegularUser, Developer {
}
