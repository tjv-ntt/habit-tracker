import Foundation
import Shared

struct HabitWrapper: Identifiable {
    var id: UUID
    var habit: Shared.Habit

    init(habit: Shared.Habit) {
        self.id = UUID() // or use an existing property if available
        self.habit = habit
    }
}
