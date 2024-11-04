package com.example.application

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class NutritionistAppApplicationSpec extends Specification {

  def "context loads"() {
    expect:
    true
  }
}