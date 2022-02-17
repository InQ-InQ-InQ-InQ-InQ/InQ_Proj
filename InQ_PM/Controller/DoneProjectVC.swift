//
//  DoneProjectVC.swift
//  InQ_PM
//
//  Created by RooZin on 2022/02/15.
//

import UIKit

class DoneProjectVC: UIViewController {

    var projectManager = ProjectManager()
    var projectData : [ProjectData] = []
    
    let refresh = UIRefreshControl()
    
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        tableView.delegate = self
        tableView.dataSource = self
        
        projectManager.delegate = self
        self.initRefresh()
    }
}

//MARK: - ProjectManagerDelegate

extension DoneProjectVC : ProjectManagerDelegate {
    func updateProjectList(_ data: [ProjectData]) {
        projectData = data
    }
}

//MARK: - UITableViewDelegate, UITableViewDataSource

extension DoneProjectVC : UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return projectData.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "cardCell", for: indexPath) as? CardTableViewCell else {
            fatalError("No CardTableViewCell for cardCell id")
        }
        
        // Put data into the cell
        
        cell.projectID.text = projectData[indexPath.row].projectName
        cell.detail.text = projectData[indexPath.row].details
        cell.techList.text = projectData[indexPath.row].techList
        
        return cell
    }
}

//MARK: - RefreshControl

extension DoneProjectVC {
    func initRefresh() {
            refresh.addTarget(self, action: #selector(refreshTable(refresh:)), for: .valueChanged)
            refresh.backgroundColor = UIColor.clear
            self.tableView.refreshControl = refresh
        }
     
        @objc func refreshTable(refresh: UIRefreshControl) {
            print("refreshTable")
            projectManager.filteringProject("FIN")
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.0) {
                self.tableView.reloadData()
                refresh.endRefreshing()
            }
        }
     
        //MARK: - UIRefreshControl of ScrollView
        func scrollViewWillEndDragging(_ scrollView: UIScrollView, withVelocity velocity: CGPoint, targetContentOffset: UnsafeMutablePointer<CGPoint>) {
            if(velocity.y < -0.1) {
                self.refreshTable(refresh: self.refresh)
            }
        }
}
