package com.automate.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class TestData {

  private AppTestData AppTestData;
}
