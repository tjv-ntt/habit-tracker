import SwiftUI

struct HabitCardList: View {
    @ObservedObject var viewModel: HomeViewModel

    var body: some View {
        if viewModel.allHabits.isEmpty {
            Text("There are no habits")
                .accessibilityIdentifier("NoHabitsText")
        } else {
            List(viewModel.allHabits.map { HabitWrapper(habit: $0) }) { habitWrapper in
                HabitCard(habit: habitWrapper).listRowSeparator(.hidden)
            }
            .listStyle(.plain)
            .accessibilityIdentifier("HabitCardList")
        }
    }
}
