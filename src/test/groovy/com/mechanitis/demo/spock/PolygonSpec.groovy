package com.mechanitis.demo.spock

import spock.lang.Specification

class PolygonSpec extends Specification{


    def "should demonstrate given-what-then"() {
        given:
        def polygon = new Polygon(10)

        when:
        int sidesOfPolygon = polygon.numberOfSides

        then:
        10 == sidesOfPolygon
    }

    def "should expect Exceptions"(){
        when:
        new Polygon(0)

        then:
        def exception = thrown(TooFewSidesException)
        exception.numberOfSides == 0
    }

    def "should expect Exception to be thrown for a number of invalid inputs of sides"(){
        when:
        new Polygon(sides)

        then:
        def exception = thrown(TooFewSidesException)
        exception.numberOfSides == sides

        where:
        sides << [0, 1, 2]
    }
}
