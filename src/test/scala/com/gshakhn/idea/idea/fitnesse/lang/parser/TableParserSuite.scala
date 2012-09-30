package com.gshakhn.idea.idea.fitnesse.lang.parser

import com.gshakhn.idea.idea.fitnesse.lang.lexer.FitnesseTokenType

class TableParserSuite extends ParserSuite {
  test("Simple decision table with no prefix") {
    expect(
      Node(FitnesseElementType.FILE, List(
        Node(TableElementType.DECISION_TABLE, List(
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "A"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "B"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "C"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          ))
        ))
      ))
    ) {
      parse("|A|\n|B|\n|C|\n\n")
    }
  }

  test("Simple decision table with no prefix with more cell text") {
    expect(
      Node(FitnesseElementType.FILE, List(
        Node(TableElementType.DECISION_TABLE, List(
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "Should I buy it"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "have money"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "buy it?"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          ))
        ))
      ))
    ) {
      parse("|Should I buy it|\n|have money|buy it?|\n|yes|yes|\n\n")
    }
  }

  test("Simple decision table with 'dt' prefix") {
    expect(
      Node(FitnesseElementType.FILE, List(
        Node(TableElementType.DECISION_TABLE, List(
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.TABLE_TYPE, "dt"),
            Leaf(FitnesseTokenType.COLON, ":"),
            Leaf(FitnesseTokenType.CELL_TEXT, "Should I buy it"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "have money"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "buy it?"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          ))
        ))
      ))
    ) {
      parse("|dt:Should I buy it|\n|have money|buy it?|\n|yes|yes|\n\n")
    }
  }

  test("Simple decision table with 'decision' prefix") {
    expect(
      Node(FitnesseElementType.FILE, List(
        Node(TableElementType.DECISION_TABLE, List(
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.TABLE_TYPE, "dt"),
            Leaf(FitnesseTokenType.COLON, ":"),
            Leaf(FitnesseTokenType.CELL_TEXT, "Should I buy it"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "have money"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "buy it?"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "yes"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          ))
        ))
      ))
    ) {
      parse("|dt:Should I buy it|\n|have money|buy it?|\n|yes|yes|\n\n")
    }
  }

  test("Query table") {
    expect(
      Node(FitnesseElementType.FILE, List(
        Node(TableElementType.QUERY_TABLE, List(
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.TABLE_TYPE, "query"),
            Leaf(FitnesseTokenType.COLON, ":"),
            Leaf(FitnesseTokenType.CELL_TEXT, "stuff"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "param1"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "foo field"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "bar field"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          )),
          Node(FitnesseElementType.ROW, List(
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "1"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|"),
            Leaf(FitnesseTokenType.CELL_TEXT, "2"),
            Leaf(FitnesseTokenType.CELL_DELIM, "|")
          ))
        ))
      ))
    ) {
      parse("|query:stuff|param1|\n|foo field|bar field|\n|1|2|")
    }
  }
}