// HomeViewModel.swift
import Foundation
import Combine
import Shared

class HomeViewModel: ObservableObject {
    @Published var allHabits: [Shared.Habit] = []
    private let getAllHabitsUseCase: GetAllHabitsUseCase
    let habitRepository: HabitRepository

    init(getAllHabitsUseCase: GetAllHabitsUseCase, habitRepository: HabitRepository = HabitRepositoryHelper().getHabitRepository()) {
        self.getAllHabitsUseCase = getAllHabitsUseCase
        self.habitRepository = habitRepository
    }

    @MainActor
    func getAllHabits() async {
        do {
            let habits = try await getAllHabitsUseCase.execute()
            self.allHabits = habits
        } catch {
            print("Failed to fetch habits: \(error)")
        }
    }
}
