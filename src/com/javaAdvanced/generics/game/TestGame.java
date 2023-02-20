package com.javaAdvanced.generics.game;


/**
 * В этом примере(если не использовать generics) наглядно обозначена проблема того, что можно добавить любого
 * участника в любую команду, что ведет за собой множество проблем;
 *
 * Если НЕ произвести extends T от необходимого класса, то станет возможной такая строка:
 * Team<String> anyTeam = new Team<>("WrongTeam");    что конечно же недопустимо;
 */
public class TestGame {

    public static void main(String[] args) {

        // школьники
        Schoolar schoolar1 = new Schoolar("Igor", 8);
        Schoolar schoolar2 = new Schoolar("Masha", 9);
        Schoolar schoolar3 = new Schoolar("Peter", 6);
        Schoolar schoolar4 = new Schoolar("Kate", 8);

        // студенты
        Students student1 = new Students("Alex", 17);
        Students student2 = new Students("Rebekka", 17);

        // взрослые
        Employees employee1 = new Employees("Rachel", 28);
        Employees employee2 = new Employees("Mike", 31);

        // школьники, 2 разные команды
        Team<Schoolar> schoolTeam1 = new Team<>("Dragons");
        schoolTeam1.addNewParticipant(schoolar1);
        schoolTeam1.addNewParticipant(schoolar2);
        Team<Schoolar> schoolTeam2 = new Team<>("Flowers");
        schoolTeam2.addNewParticipant(schoolar3);
        schoolTeam2.addNewParticipant(schoolar4);

        // студенты
        Team<Students> studentsTeam = new Team<>("Voyagers");
        studentsTeam.addNewParticipant(student1);
        studentsTeam.addNewParticipant(student2);

        // взрослые
        Team<Employees> employeeTeam = new Team<>("Sad_Workers");
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        // проводим игру между школьниками, получаем победителя
        // однако, без типа T в методе playWith можно будет соревноваться взрослым с детьми
        // как только тип указан, компилятор не позволит подставить в метод команду взрослых
        schoolTeam1.playWith(schoolTeam2);

    }


}
