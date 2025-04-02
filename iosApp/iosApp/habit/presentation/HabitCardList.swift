import SwiftUI

struct HabitCardList: View {
    @ObservedObject var viewModel: HomeViewModel

    var body: some View {
        VStack {
            if viewModel.allHabits.isEmpty {
                Text("There are no habits")
                    .accessibilityIdentifier("NoHabitsText")
            } else {
                List(viewModel.allHabits.map { HabitWrapper(habit: $0) }) {
                    habitWrapper in
                    HabitCard(
                        habit: habitWrapper
//                        onDelete: {
//                            Task {
//                                await viewModel.deleteHabit(
//                                    habit: habitWrapper.habit)
//                            }
//                        }
                    )
                    .listRowSeparator(.hidden)
                }
                .listStyle(.plain)
                .accessibilityIdentifier("HabitCardList")
            }
        }
        .onAppear {
            Task {
                await viewModel.getAllHabits()
            }
        }
    }
}
