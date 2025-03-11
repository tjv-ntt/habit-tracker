//copied from https://dev.to/kafran/swiftui-list-card-view-2da4

import SwiftUI

struct HabitCardList: View {

    var body: some View {
        List {
            HabitCard().listRowSeparator(.hidden)
            HabitCard().listRowSeparator(.hidden)
            HabitCard().listRowSeparator(.hidden)
        }
        .listStyle(.plain)
        .accessibilityIdentifier("HabitCardList")
        }
}
