import XCTest

func getAppView(identifier: String) -> XCUIElement {
    return XCUIApplication().descendants(matching: .any).matching(identifier: identifier).element
}
