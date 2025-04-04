import Foundation
import Shared

struct HabitWrapper: Identifiable {
    var id: Int32
    var habit: Shared.Habit

    init(habit: Shared.Habit) {
        self.id = habit.id // or use an existing property if available
        self.habit = habit
    }
}
