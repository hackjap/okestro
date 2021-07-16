<template>
	<v-simple-table>
		<template v-slot:default>
			<thead>
				<tr>
					<th class="text-left">
						회원명
					</th>
					<th class="text-left">
						백신종류
					</th>
					<th class="text-left">
						상태
					</th>
					<th class="text-left">
						날짜
					</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="item in items" :key="item.name">
					<td>{{ item.userName }}</td>
					<td>{{ item.orderName }}</td>
					<td>{{ item.orderStatus }}</td>
					<td>{{ `${item.orderDate.slice(0, 10)}` }}</td>
					<v-container>
						<v-btn @click="cancelOrder(item.orderId)" color="grey">
							취소
						</v-btn>
						<v-btn
							@click="finishOrder(item.orderId)"
							v-if="isAdmin"
							color="grey"
						>
							완료
						</v-btn>
						<v-btn
							@click="deleteOrder(item.orderId)"
							v-if="isAdmin"
							color="grey"
						>
							삭제
						</v-btn>
					</v-container>
				</tr>
			</tbody>
		</template>
	</v-simple-table>
</template>
<script>
import {
	fetchOrders,
	cancelOrderVaccine,
	deletelOrderVaccine,
	completeOrderVaccine,
} from '@/api/index';

export default {
	data() {
		return {
			items: [],
			oneOrderId: 0,
		};
	},
	computed: {
		isAdmin() {
			return this.$store.state.name == 'admin@naver.com';
		},
	},
	async mounted() {
		const { data } = await fetchOrders();
		console.log(data);
		this.items = data;
	},

	methods: {
		// 예약 취소
		async cancelOrder(orderId) {
			await cancelOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
		// 예약 삭제
		async deleteOrder(orderId) {
			await deletelOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},

		// 접종 완료
		async finishOrder(orderId) {
			await completeOrderVaccine(orderId);
			// 데이터 변경사항 적용
			const { data } = await fetchOrders();
			this.items = data;
		},
	},
};
</script>
