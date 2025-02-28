//
//  HabitHomeScreen.swift
//  HabitTrackerUITests
//
//  Created by NTTDATA on 2/28/25.
//  Copyright © 2025 orgName. All rights reserved.
//

import XCTest

final class HabitHomeScreen: XCTestCase {
    let app = XCUIApplication()

    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.

        // In UI tests it is usually best to stop immediately when a failure occurs.
        continueAfterFailure = false

        // In UI tests it’s important to set the initial state - such as interface orientation - required for your tests before they run. The setUp method is a good place to do this.
        app.launch()
    }

    override func tearDownWithError() throws {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }

    func testHelloWorld() throws {
        // UI tests must launch the application that they test.
        let expectedText = "Hello World!"
        
        // Or to verify text content:
        XCTAssertEqual(app.staticTexts["Hello World!"].firstMatch.label, expectedText)

        // Use XCTAssert and related functions to verify your tests produce the correct results.
    }
}
