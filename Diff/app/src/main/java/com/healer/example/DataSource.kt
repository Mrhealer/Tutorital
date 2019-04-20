package com.healer.example

class DataSource {
    fun getData(): MutableList<Person> {
        val personOne = Person("Long Tran", "Love is in the air lets tie a mask.")
        val personTwo = Person("Jeeveshu", "I don't want to eat man.")
        val personThree = Person("Jaspreet Singh", "I want to fly high.")
        val personFour = Person("Undertaker", "In love with WWE.")
        return mutableListOf(personOne, personTwo, personThree, personFour)
    }


    fun getUpdateData(): MutableList<Person> {
        val listOfPerson = getData()
        listOfPerson[0].name = "Fuck Up"
        listOfPerson[0].status = " Fucking ......................"
        print(listOfPerson)
        return listOfPerson
    }

}